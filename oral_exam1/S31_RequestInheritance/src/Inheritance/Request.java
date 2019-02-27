package Inheritance;

import java.util.UUID;

/**
 * Class Request
 */
public class Request {
    /**
     * Private class member UUID
     */
    private UUID UUID;
    private  int count = 0;

    public Request(UUID UUID) {
        this.UUID = UUID;
        count++;
    }

    /**
     * A getter method for UUID
     * @return UUID
     */
    public UUID getUUID() {
        return UUID;
    }

    /**
     * Override super class toString function
     * @return string
     */
    @Override
    public String toString() {
        return super.toString() + "\nUUID: " + getUUID();
    }
    /**
     * Return integer count
     * @return int count
     */
    public  int count() {
        return count;
    }
}
