package org.voovan.docker.message.service.atom;

/**
 *
 * @author helyho
 * <p>
 * DockerFly Framework.
 * WebSite: https://git.oschina.net/helyho/JDocker
 * Licence: Apache v2 License
 */
public class Resource {
    private ResourcePolicy limits;
    private ResourcePolicy reservations;

    public Resource() {
        limits = new ResourcePolicy();
        reservations = new ResourcePolicy();
    }

    public ResourcePolicy getLimits() {
        return limits;
    }

    public void setLimits(ResourcePolicy limits) {
        this.limits = limits;
    }

    public ResourcePolicy getReservations() {
        return reservations;
    }

    public void setReservations(ResourcePolicy reservations) {
        this.reservations = reservations;
    }


}
