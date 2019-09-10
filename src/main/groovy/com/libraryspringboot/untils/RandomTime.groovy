package com.libraryspringboot.untils

class RandomTime {

    static Random rd = new Random()

    static long getRandom(){
        return (long) (6 + rd.nextInt(300))
    }

}
