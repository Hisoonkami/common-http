package com.adev.common.http;

import com.adev.common.http.domain.RequestParam;
import com.adev.common.http.service.HttpStreamingService;
import io.reactivex.disposables.Disposable;

public class HttpStreamingServiceTest {
    public static void main(String[] args) throws InterruptedException {
        HttpStreamingService httpStreamingService=new HttpStreamingService("baidu");
        httpStreamingService.connect();
        RequestParam param = new RequestParam();
        param.setUrl("https://www.baidu.com");
        Disposable disposable=httpStreamingService.pollingRestApi(param).subscribe(e->{
            System.out.println(e);
        });
        Thread.sleep(20000L);
        disposable.dispose();
        httpStreamingService.disconnect();
    }
}
