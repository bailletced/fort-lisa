package utils.file



class FileReaderResource {
     fun read(path: String): String {
        val content =
            this::class.java.getResource(path)?.readText()
        if (content.isNullOrEmpty()) {
            throw Exception("no file found. Path : $path")
        }

        return content
    }
}
