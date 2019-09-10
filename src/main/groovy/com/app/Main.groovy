package com.app


import java.util.concurrent.Executors
import java.util.concurrent.Semaphore

class Main {
    public static void main(String[] args) {
        def numOfBooks = 5
        def numOfUser = 100

        def minReadTimeMs = 1000
        def maxReadTimeMs = 5000

        def start = System.currentTimeMillis()
//        def semaphore = new Semaphore(numOfBooks)

        def bookResource = [:]
        (1..numOfBooks).each {
            bookResource.put(it, 0)
        }

        def threadPool = Executors.newFixedThreadPool(numOfBooks)

        def takeABook = { Integer userId ->
            synchronized (bookResource) {
                if (!(bookResource.find { it.value == 0 })) {
                    bookResource.wait()
                }

                def bookId = bookResource.find { it.value == 0 }.key
                bookResource[bookId] = userId

                return bookId
            }
        }

        def releaseBook = { Integer bookId ->
            synchronized (bookResource) {
                // lấy người đang đọc sách đó
                def _userId = bookResource[bookId]
                bookResource[bookId] = 0
                bookResource.notifyAll()

                return _userId
            }
        }

        (1..numOfUser).each { userId ->
            threadPool.submit({
                def readTime = new Random().nextInt(maxReadTimeMs) + minReadTimeMs

                def bookId = takeABook(userId)
                println "${(System.currentTimeMillis() - start) / 1000} User[$userId] read Book[$bookId] = $readTime ms"
                sleep(readTime)
                def _userId = releaseBook(bookId)
                println "${(System.currentTimeMillis() - start) / 1000} User[$userId] done Book[$bookId] = $readTime ms"

                assert _userId == userId: "$_userId != $userId"
            })
        }

        new Scanner(System.in).next()
        threadPool.shutdown()
    }
}
