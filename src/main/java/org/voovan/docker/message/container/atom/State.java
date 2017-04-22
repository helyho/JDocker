package org.voovan.docker.message.container.atom;

/**
 * 类文字命名
 *
 * @author: helyho
 * JDocker Framework.
 * WebSite: https://github.com/helyho/JDocker
 * Licence: Apache v2 License
 */
public class State {
    private String status;
    private Boolean running;
    private Boolean paused;
    private Boolean restarting;
    private Boolean oOMKilled;
    private Boolean dead;
    private Integer pid;
    private Integer exitCode;
    private String error;
    private String startedAt;
    private String finishedAt;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Boolean getRunning() {
        return running;
    }

    public void setRunning(Boolean running) {
        this.running = running;
    }

    public Boolean getPaused() {
        return paused;
    }

    public void setPaused(Boolean paused) {
        this.paused = paused;
    }

    public Boolean getRestarting() {
        return restarting;
    }

    public void setRestarting(Boolean restarting) {
        this.restarting = restarting;
    }

    public Boolean getoOMKilled() {
        return oOMKilled;
    }

    public void setoOMKilled(Boolean oOMKilled) {
        this.oOMKilled = oOMKilled;
    }

    public Boolean getDead() {
        return dead;
    }

    public void setDead(Boolean dead) {
        this.dead = dead;
    }

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    public Integer getExitCode() {
        return exitCode;
    }

    public void setExitCode(Integer exitCode) {
        this.exitCode = exitCode;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public String getStartedAt() {
        return startedAt;
    }

    public void setStartedAt(String startedAt) {
        this.startedAt = startedAt;
    }

    public String getFinishedAt() {
        return finishedAt;
    }

    public void setFinishedAt(String finishedAt) {
        this.finishedAt = finishedAt;
    }
}
