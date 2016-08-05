    对于Java Socket编程而言，有两个概念，一个是ServerSocket，一个是Socket。服务端和客户端之间通过Socket建立连接， 之后它们就可以进行通信了。
    首先ServerSocket将在服务端监听某个端口，当发现客户端有Socket来试图连接它时，它会accept该Socket的连接请求，同时在服务端建立一个对应的
    Socket与之进行通信。这样就有两个Socket了，客户端和服务端各一个。
