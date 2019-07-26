package com.demo.client;

import com.demo.grpc.CommonRequest;
import com.demo.grpc.CommonResponse;
import com.demo.grpc.SimpleGrpc;
import com.demo.grpc.StreamResponse;
import io.grpc.Channel;
import net.devh.springboot.autoconfigure.grpc.client.GrpcClient;
import org.springframework.stereotype.Service;

import java.util.Iterator;


/**
 * @Classname ClientService
 * @Description TODO
 * @Date 2019/6/22 16:29
 * @Created by ChenS
 */
@Service
public class ClientService {
    @GrpcClient("local-ser")
    private Channel local;

    public String getMessage(String name) {
        SimpleGrpc.SimpleBlockingStub stub = SimpleGrpc.newBlockingStub(local);
        CommonResponse response = stub.hello(
                CommonRequest.newBuilder()
                        .setHeader("this is header")
                        .setBody("this is body,name is" + name)
                        .build());
        return "note:" + response.getNote() + "\t code:" + response.getCode();
    }

    public String getStreamMessage(String name) {
        SimpleGrpc.SimpleBlockingStub stub = SimpleGrpc.newBlockingStub(local);
        Iterator<StreamResponse> streamResponses = stub.streamServerHello(
                CommonRequest.newBuilder()
                        .setHeader("this is header")
                        .setBody("this is body,name is" + name)
                        .build()
        );
        String res = "";
        while (streamResponses.hasNext()) {
            StreamResponse response = streamResponses.next();
            res += response.toString() + "\n";
        }
        return res;
    }
}
