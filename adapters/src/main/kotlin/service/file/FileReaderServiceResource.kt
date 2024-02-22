package service.file

import gateways.service.file.IFileReaderService

class FileReaderServiceResource : IFileReaderService {
    override fun read(path: String): String {
        val content =
            this::class.java.getResource(path)?.readText()
        if (content.isNullOrEmpty()) {
            throw Exception("no file found. Path : $path")
        }

        return content
    }
}
