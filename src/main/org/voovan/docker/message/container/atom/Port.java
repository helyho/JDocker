package org.voovan.docker.message.container.atom;

/**
 * 类文字命名
 *
 * @author helyho
 *         <p>
 *         DockerFly Framework.
 *         WebSite
 *         Licence
 */
public class Port {

   private String iP;
   private String privatePort;
   private String publicPort;
   private String type;

   public String getiP() {
      return iP;
   }

   public void setiP(String iP) {
      this.iP = iP;
   }

   public String getPrivatePort() {
      return privatePort;
   }

   public void setPrivatePort(String privatePort) {
      this.privatePort = privatePort;
   }

   public String getPublicPort() {
      return publicPort;
   }

   public void setPublicPort(String publicPort) {
      this.publicPort = publicPort;
   }

   public String getType() {
      return type;
   }

   public void setType(String type) {
      this.type = type;
   }
}
