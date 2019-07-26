package com.demo.server;

import com.demo.grpc.CommonRequest;
import com.demo.grpc.CommonResponse;
import com.demo.grpc.SimpleGrpc;
import com.demo.grpc.StreamResponse;
import com.demo.service.GetSourceService;
import io.grpc.stub.StreamObserver;
import net.devh.springboot.autoconfigure.grpc.server.GrpcService;
import org.springframework.beans.factory.annotation.Autowired;

@GrpcService(SimpleGrpc.class)
public class ServerService extends SimpleGrpc.SimpleImplBase {

    @Autowired
    private GetSourceService sourceService;

    @Override
    public void hello(CommonRequest request, StreamObserver<CommonResponse> responseObserver) {
        System.out.println("waiting......");
        String re = sourceService.getPostContent("https://image.baidu.com", "");
        System.out.println(re);
        CommonResponse response = CommonResponse.newBuilder()
                .setCode(1)
                .setNote("成功,\n获取的头部信息为：" + request.getHeader() + "\n获取的内容为：" + request.getBody() + "  --->" + re)
                .build();
        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }

    @Override
    public void streamServerHello(CommonRequest request, StreamObserver<StreamResponse> responseObserver) {
        StreamResponse.Builder builderStream = StreamResponse.newBuilder();
        builderStream
                .setCode(1)
                //在消息中添加获取的请求header和body内容
                .setMessage("stream response,request header:->" + request.getHeader() + " request body:->" + request.getBody());
        //添加集合返回对象
        int count = 15;
        for (int i = 0; i < 15; i++) {
            CommonResponse response = CommonResponse.newBuilder()
                    .setCode(i)
                    .setNote("common response" + i)
                    .build();
            builderStream.addRecord(response);
        }

        StreamResponse streamResponse = builderStream.setCount(count).build();
        responseObserver.onNext(streamResponse);
        responseObserver.onNext(streamResponse);
        responseObserver.onCompleted();
    }


}
