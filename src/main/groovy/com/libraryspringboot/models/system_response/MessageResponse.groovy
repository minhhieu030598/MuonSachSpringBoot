package com.libraryspringboot.models.system_response

class MessageResponse {

    int code

    String title

    String message

    static public Map data = new HashMap()

    MessageResponse(int code, String title, String message) {
        this.code = code
        this.title = title
        this.message = message
    }

    static {
        data.put("inserted", new MessageResponse(200, "OK", "Đã thêm thành công bản ghi !"))
        data.put("updated", new MessageResponse(200, "OK", "Đã sửa thành công bản ghi !"))
        data.put("deleted", new MessageResponse(200, "OK", "Đã xóa thành công bản ghi !"))
        data.put("error_server",new MessageResponse(500, "Fail", "Máy chủ gặp lỗi !") )
        data.put("error_other",new MessageResponse(500, "Fail", "Máy chủ gặp lỗi !") )
    }

}
