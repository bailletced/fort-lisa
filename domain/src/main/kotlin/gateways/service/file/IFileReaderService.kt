package gateways.service.file

interface IFileReaderService {
    fun read(path: String): String
}
