/*
 * Copyright 2019 Jenly Yu
 * <a href="mailto:jenly1314@gmail.com">Jenly</a>
 * <a href="https://github.com/jenly1314">jenly1314</a>
 *
 * The Netty Project licenses this file to you under the Apache License,
 * version 2.0 (the "License"); you may not use this file except in compliance
 * with the License. You may obtain a copy of the License at:
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations
 * under the License.
 */
package com.king.anetty;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelPromise;

/**
 * @author <a href="mailto:jenly1314@gmail.com">Jenly</a>
 */
public interface Netty {

    /**
     * 建立连接
     * @param host
     * @param port
     */
    void connect(@NonNull String host,int port);

    /**
     * 重连
     */
    void reconnect(long delayMillis);

    /**
     * 发送消息
     * @param msg
     */
    void sendMessage(@NonNull Object msg);

    /**
     * 连接监听
     * @param listener
     */
    void setOnConnectListener(OnConnectListener listener);

    /**
     * 关闭
     */
    void close();

    /**
     * 断开链接
     */
    void disconnect();

    /**
     * 是否连接
     * @return
     */
    boolean isConnected();

    /**
     * 是否打开
     * @return
     */
    boolean isOpen();

    /**
     * 获取{@link ChannelFuture}
     * @return
     */
    ChannelFuture getChannelFuture();

    /**
     * 连接监听
     */
    interface OnConnectListener{
        void onSuccess();
        void onFailed();
        void onError(Exception e);
    }

    interface OnChannelHandler{
        void onMessageReceived(String msg);
        void onExceptionCaught(Throwable e);
    }
}
