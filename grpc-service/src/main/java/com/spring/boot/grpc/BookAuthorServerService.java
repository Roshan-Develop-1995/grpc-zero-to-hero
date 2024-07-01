package com.spring.boot.grpc;

import io.grpc.stub.StreamObserver;
import net.devh.boot.grpc.server.service.GrpcService;

@GrpcService
public class BookAuthorServerService extends BookAuthorServiceGrpc.BookAuthorServiceImplBase{

    @Override
    public void getAuthor(Author request, StreamObserver<Author> responseObserver){
        TempDB.getAuthorsFromTempDB().stream()
                .filter(author -> author.getAuthorId() == request.getAuthorId())
                .findFirst()
                .ifPresent(responseObserver::onNext);
        //onNext - sends the response back to client
        //onCompleted will be called at the end when we have successfully completed the operations
        //onError will be called in case of any exception occurred while the operation
        //responseObserver.onError(new RuntimeException("Error occurred"));
        responseObserver.onCompleted();
    }
}
