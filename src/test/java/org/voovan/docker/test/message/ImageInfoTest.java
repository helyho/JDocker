package org.voovan.docker.test.message;

import org.voovan.docker.message.Image.ImageDetail;
import org.voovan.docker.message.Image.ImageListInfo;
import org.voovan.tools.log.Logger;

import java.text.ParseException;
import java.util.List;

/**
 *
 * @author helyho
 * <p>
 * DockerFly Framework.
 * WebSite: https://git.oschina.net/helyho/JDocker
 * Licence: Apache v2 License
 */
public class ImageInfoTest {

    public static String tmp = "[\n" +
            "  {\n" +
            "    \"Id\": \"sha256:68a70731abcf825ba91fb011972023febdd71e53760a9da0797ae50e6c5c5282\",\n" +
            "    \"ParentId\": \"sha256:561f511a30a8b5e94574c9005cc1a6fb91e773e7c28987c3a7e47fbad647a839\",\n" +
            "    \"RepoTags\": [\n" +
            "      \"myrepo:latest\"\n" +
            "    ],\n" +
            "    \"RepoDigests\": null,\n" +
            "    \"Created\": 1476881256,\n" +
            "    \"Size\": 8028292,\n" +
            "    \"VirtualSize\": 8028292,\n" +
            "    \"Labels\": {}\n" +
            "  },\n" +
            "  {\n" +
            "    \"Id\": \"sha256:561f511a30a8b5e94574c9005cc1a6fb91e773e7c28987c3a7e47fbad647a839\",\n" +
            "    \"ParentId\": \"sha256:9465c893364d79eb45ab952b3efa40a0a9748a0c4223571619a892fb7f028b8a\",\n" +
            "    \"RepoTags\": [\n" +
            "      \"dockerfly:latest\"\n" +
            "    ],\n" +
            "    \"RepoDigests\": null,\n" +
            "    \"Created\": 1476870324,\n" +
            "    \"Size\": 8028292,\n" +
            "    \"VirtualSize\": 8028292,\n" +
            "    \"Labels\": {}\n" +
            "  }" +
            "]";

    public static String imageDetailTmp = "{\n" +
            "  \"Id\": \"sha256:a195358e54f8d840eb0ae951aa7ce4d99730f0a092530b1a472f239c28c19e24\",\n" +
            "  \"RepoTags\": [\n" +
            "    \"df:latest\",\n" +
            "    \"dockerfly:latest\"\n" +
            "  ],\n" +
            "  \"RepoDigests\": [],\n" +
            "  \"Parent\": \"sha256:b9c9d4b670daff16231441a5d7b3fd50c62bcde2223de9c683a6d7986b291223\",\n" +
            "  \"Comment\": \"\",\n" +
            "  \"Created\": \"2017-03-17T11:14:50.920959577Z\",\n" +
            "  \"Container\": \"34f97f2d8cc33538c5b243ccc65ccf07086f06e68f622c3e4168fb984449b31a\",\n" +
            "  \"ContainerConfig\": {\n" +
            "    \"Hostname\": \"84baa8e89c00\",\n" +
            "    \"Domainname\": \"\",\n" +
            "    \"User\": \"\",\n" +
            "    \"AttachStdin\": false,\n" +
            "    \"AttachStdout\": false,\n" +
            "    \"AttachStderr\": false,\n" +
            "    \"ExposedPorts\": {\n" +
            "      \"2735/tcp\": {},\n" +
            "      \"28083/tcp\": {}\n" +
            "    },\n" +
            "    \"Tty\": false,\n" +
            "    \"OpenStdin\": false,\n" +
            "    \"StdinOnce\": false,\n" +
            "    \"Env\": [\n" +
            "      \"PATH=/usr/local/sbin:/usr/local/bin:/usr/sbin:/usr/bin:/sbin:/bin:/usr/lib/jvm/default-jvm/bin/\",\n" +
            "      \"HOME=/root\",\n" +
            "      \"JAVA_VERSION_MAJOR=8\",\n" +
            "      \"JAVA_VERSION_MINOR=112\",\n" +
            "      \"JAVA_VERSION_BUILD=15\",\n" +
            "      \"JAVA_HOME=/usr/lib/jvm/default-jvm\"\n" +
            "    ],\n" +
            "    \"Cmd\": [\n" +
            "      \"/bin/sh\",\n" +
            "      \"-c\",\n" +
            "      \"#(nop) \",\n" +
            "      \"ENTRYPOINT [\\\"/bin/sh\\\" \\\"-c\\\" \\\"\\\\\\\"./start.sh\\\\\\\"\\\"]\"\n" +
            "    ],\n" +
            "    \"ArgsEscaped\": true,\n" +
            "    \"Image\": \"sha256:b9c9d4b670daff16231441a5d7b3fd50c62bcde2223de9c683a6d7986b291223\",\n" +
            "    \"Volumes\": {\n" +
            "      \"/backup\": {}\n" +
            "    },\n" +
            "    \"WorkingDir\": \"/dockerfly\",\n" +
            "    \"Entrypoint\": [\n" +
            "      \"/bin/sh\",\n" +
            "      \"-c\",\n" +
            "      \"\\\"./start.sh\\\"\"\n" +
            "    ],\n" +
            "    \"OnBuild\": [],\n" +
            "    \"Labels\": {}\n" +
            "  },\n" +
            "  \"DockerVersion\": \"17.03.0-ce\",\n" +
            "  \"Author\": \"helyho <helyho@gmail.com>\",\n" +
            "  \"Config\": {\n" +
            "    \"Hostname\": \"84baa8e89c00\",\n" +
            "    \"Domainname\": \"\",\n" +
            "    \"User\": \"\",\n" +
            "    \"AttachStdin\": false,\n" +
            "    \"AttachStdout\": false,\n" +
            "    \"AttachStderr\": false,\n" +
            "    \"ExposedPorts\": {\n" +
            "      \"2735/tcp\": {},\n" +
            "      \"28083/tcp\": {}\n" +
            "    },\n" +
            "    \"Tty\": false,\n" +
            "    \"OpenStdin\": false,\n" +
            "    \"StdinOnce\": false,\n" +
            "    \"Env\": [\n" +
            "      \"PATH=/usr/local/sbin:/usr/local/bin:/usr/sbin:/usr/bin:/sbin:/bin:/usr/lib/jvm/default-jvm/bin/\",\n" +
            "      \"HOME=/root\",\n" +
            "      \"JAVA_VERSION_MAJOR=8\",\n" +
            "      \"JAVA_VERSION_MINOR=112\",\n" +
            "      \"JAVA_VERSION_BUILD=15\",\n" +
            "      \"JAVA_HOME=/usr/lib/jvm/default-jvm\"\n" +
            "    ],\n" +
            "    \"Cmd\": null,\n" +
            "    \"ArgsEscaped\": true,\n" +
            "    \"Image\": \"sha256:b9c9d4b670daff16231441a5d7b3fd50c62bcde2223de9c683a6d7986b291223\",\n" +
            "    \"Volumes\": {\n" +
            "      \"/backup\": {}\n" +
            "    },\n" +
            "    \"WorkingDir\": \"/dockerfly\",\n" +
            "    \"Entrypoint\": [\n" +
            "      \"/bin/sh\",\n" +
            "      \"-c\",\n" +
            "      \"\\\"./start.sh\\\"\"\n" +
            "    ],\n" +
            "    \"OnBuild\": [],\n" +
            "    \"Labels\": {}\n" +
            "  },\n" +
            "  \"Architecture\": \"amd64\",\n" +
            "  \"Os\": \"linux\",\n" +
            "  \"Size\": 95818356,\n" +
            "  \"VirtualSize\": 95818356,\n" +
            "  \"GraphDriver\": {\n" +
            "    \"Name\": \"overlay2\",\n" +
            "    \"Data\": {\n" +
            "      \"LowerDir\": \"/var/lib/docker/overlay2/6e57ad7a50bd25f3f3cc68e4c75b8485915cb32f397e79f2062091e892342a7a/diff:/var/lib/docker/overlay2/1e07dd64a4d189e26b8e49d16d048f611853f715c30cbefe6d302ddf824ab387/diff:/var/lib/docker/overlay2/912a5fd7ab5c27f2d563aa8a943f1cb42e8d1af89edc0625327288009d340a41/diff:/var/lib/docker/overlay2/835c84d3650fb418817e5ff82e2b7bc235f3d468821631100958c2df0de59ccf/diff:/var/lib/docker/overlay2/b0b970eb1847c1844031a7a63a9fefd139a8c54d67ab7695bf1e07bba8735b00/diff:/var/lib/docker/overlay2/6095bca5b5b3c8b47277f59e83e715a5811572d643d63fba7df3737a8e05b995/diff:/var/lib/docker/overlay2/af507d07525d426633fc2cd2d39eb73d92e9bfa6777326edf85c8bb6b2b76e0c/diff:/var/lib/docker/overlay2/e46cbabfad17d5c3c88f146641d4d8b217023b93fd37ff6c0c9bad14a6cbfb4b/diff:/var/lib/docker/overlay2/a141b38a098835674e72874506380fc6d3047f4ab26b0defe8c33fd4adee65a1/diff\",\n" +
            "      \"MergedDir\": \"/var/lib/docker/overlay2/e4564eea0c48f0017eba92eb43d404ed186b7eefce3f17291e6debb50c2139e0/merged\",\n" +
            "      \"UpperDir\": \"/var/lib/docker/overlay2/e4564eea0c48f0017eba92eb43d404ed186b7eefce3f17291e6debb50c2139e0/diff\",\n" +
            "      \"WorkDir\": \"/var/lib/docker/overlay2/e4564eea0c48f0017eba92eb43d404ed186b7eefce3f17291e6debb50c2139e0/work\"\n" +
            "    }\n" +
            "  },\n" +
            "  \"RootFS\": {\n" +
            "    \"Type\": \"layers\",\n" +
            "    \"Layers\": [\n" +
            "      \"sha256:23b9c7b43573dd164619ad59e9d51eda4095926729f59d5f22803bcbe9ab24c2\",\n" +
            "      \"sha256:b58f9b41e78d7c940fca8c63af620116bb557ac9c2b74309366718e400c24fd1\",\n" +
            "      \"sha256:2dbe713c346a5ff486327608274e38b19940cff78944a362373ca1d21c81d95d\",\n" +
            "      \"sha256:f25239e4a0417451b396a82ccc8cff7fe39cadb29bc53d083154928230e382a4\",\n" +
            "      \"sha256:ca0eceb5be9c3a0e24c3faf8c3b65e5f1aca4415ffffe1e95efd9c17f34e0feb\",\n" +
            "      \"sha256:3b6e329ea11e283643120dace85f1ac28069a966adb2bce43a5aa5cb95947e69\",\n" +
            "      \"sha256:1a3133d9ac213917c36a196f000779290d493a20094a15fbdab3e694078250a6\",\n" +
            "      \"sha256:ef2128229be14e13cd26dd68e252960e305e2c14cb1f9fea81d815062c6b3aec\",\n" +
            "      \"sha256:305695f9134284551d1b10a31209a4a656ca0c931d10b4338b2c891283639af3\",\n" +
            "      \"sha256:265bb095bf8917be2c4b33204322adc46de4da08582df053655264d46dcbe98c\"\n" +
            "    ]\n" +
            "  }\n" +
            "}";


    public static void main(String[] args) throws ParseException, ReflectiveOperationException {
//        List<ImageListInfo> infos = ImageListInfo.load(tmp);
//
//        Logger.simple("CreateDate:" + infos.get(0).getCreated());
//        Logger.simple("Size:" + infos.get(0).getSize());
//        Logger.simple("VirtualSize:" + infos.get(0).getVirtualSize());


        ImageDetail detail = ImageDetail.load(imageDetailTmp);
        Logger.simple(detail.getCreated());
    }
}
