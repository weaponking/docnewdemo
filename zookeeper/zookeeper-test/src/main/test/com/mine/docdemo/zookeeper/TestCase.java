package com.mine.docdemo.zookeeper;

import lombok.extern.slf4j.Slf4j;
import org.apache.curator.RetryPolicy;
import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.retry.ExponentialBackoffRetry;
import org.apache.zookeeper.data.Stat;

/**
 * @author weapon
 * @date 2020/4/5 17:37
 */
@Slf4j
public class TestCase {

    public static void main(String[] args) {
        String zkServers = "localhost:21810";
        String nodePath = "/zk_test";

        RetryPolicy retryPolicy = new ExponentialBackoffRetry(1000, 5);
        CuratorFramework client = CuratorFrameworkFactory.builder()
                .connectString(zkServers)  // zk server ip
                .sessionTimeoutMs(10000)
                .retryPolicy(retryPolicy)
                // addauth digest admin:admin
                .authorization("digest","admin:admin".getBytes())
                //zk 根节点 /testspace
                .namespace("")
                .build();
        client.start();

        log.info("zk client state : {}", client.getState().toString());

        Stat statExist = null;
        try {
            statExist = client.checkExists().forPath(nodePath);

        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            client.setData()
                    //.withVersion(0)
                    .forPath("/zk_test", "tdata1".getBytes());
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            byte [] data = client.getData().forPath("/zk_test");
            log.info("data:{}", new String(data));
        } catch (Exception e) {
            e.printStackTrace();
        }

//        try {
//            client.delete()
//                    .guaranteed()  // 删除失败 继续删除 直到成功
//                    .deletingChildrenIfNeeded()
//                    //.withVersion(0)
//                    .forPath(nodePath);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }

        client.close();
    }
}
