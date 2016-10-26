package org.voovan.docker.message.service.atom;

/**
 * 类文字命名
 *
 * @author helyho
 *         <p>
 *         DockerFly Framework.
 *         WebSite: https://github.com/helyho/DockerFly
 *         Licence: Apache v2 License
 */
public class RestartPolicy {

    private String condition; // none/on-failure/any

    private long delay;

    private int maxAttempts;

    public RestartPolicy(){
        condition = "on-failure";
        maxAttempts = 0;
        delay = 0; //10s
    }

    public void setCondition(String condition){
        this.condition = condition;
    }
    public String getCondition(){
        return this.condition;
    }
    public void setDelay(long delay){
        this.delay = delay*1000000000L;
    }
    public long getDelay(){
        return this.delay/1000000000L;
    }
    public void setMaxAttempts(int maxAttempts){
        this.maxAttempts = maxAttempts;
    }
    public int getMaxAttempts(){
        return this.maxAttempts;
    }
}
