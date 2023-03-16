package com.data.udh;

import io.fabric8.kubernetes.api.model.Node;
import io.fabric8.kubernetes.api.model.NodeList;
import io.fabric8.kubernetes.client.KubernetesClient;
import io.fabric8.kubernetes.client.KubernetesClientBuilder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class K8sTest {

    @Test
    public void listNode() {
        KubernetesClient client = new KubernetesClientBuilder().build();
        NodeList nodeList = client.nodes().list();
        List<Node> items = nodeList.getItems();
        items.forEach(e-> {
            String cpu = e.getStatus().getCapacity().get("cpu").getAmount();
            String memory = e.getStatus().getCapacity().get("memory").getAmount();
            String ip = e.getStatus().getAddresses().get(0).getAddress();
            String hostname = e.getStatus().getAddresses().get(1).getAddress();
            String architecture = e.getStatus().getNodeInfo().getArchitecture();
            String containerRuntimeVersion = e.getStatus().getNodeInfo().getContainerRuntimeVersion();
            String kubeletVersion = e.getStatus().getNodeInfo().getKubeletVersion();
            String osImage = e.getStatus().getNodeInfo().getOsImage();

            System.out.println("cpu: "+cpu);
            System.out.println("memory: "+ memory);
            System.out.println("ip: "+ip);
            System.out.println("hostname: "+hostname);
            System.out.println("architecture: "+architecture);
            System.out.println("containerRuntimeVersion: "+containerRuntimeVersion);
            System.out.println("kubeletVersion: "+kubeletVersion);
            System.out.println("osImage: "+osImage);

            System.out.println("===============");

        });
    }
}
