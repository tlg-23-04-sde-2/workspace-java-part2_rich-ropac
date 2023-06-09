package com.entertainment;

import java.util.Objects;

/*
 *  Natural order is defined by brand (String).
 *
 *  NOTE:  be consistent with equals, natural order must use the
 *  same properties that are used in equals().
 */
public class Television implements Comparable<Television>{
    private String brand;
    private int volume;
    private Tuner tuner = new Tuner();

    public Television() {
    }

    public Television(String brand, int volume) {
        setBrand(brand);
        setVolume(volume);
    }

    //METHODS
    public int getCurrentChannel() {
        return tuner.getChannel();     //delegate to contained Tuner object
    }

    public void changeChannel(int channel){
        tuner.setChannel(channel);
    }

    //ACCESSOR METHODS

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public int getVolume() {
        return volume;
    }

    public void setVolume(int volume) {
        this.volume = volume;
    }

    @Override
    public int compareTo(Television other) {
        int result = this.getBrand().compareTo(other.getBrand());

        if (result == 0) {  //tied on brand, break the tie by volume
            result = Integer.compare(this.getVolume(), other.getVolume());
        }
        return result;
    }

//    @Override
//    public boolean equals(Object obj) {
//        if (this == obj) return true;
//
//        // is obj null? OR
//        // is obj a different type than me?
//        // comparing Class objects is an EXACT type check (not an IS-A match)
//        if (obj == null || this.getClass() != obj.getClass()) return false;
//
//        Television that = (Television) obj;
//
//        return this.getVolume() == that.getVolume() && Objects.equals(this.getBrand(), that.getBrand());
//    }
//
//    @Override
//    public int hashCode() {
//        return Objects.hash(getBrand(), getVolume());
//    }


        @Override
    public int hashCode() {
        // poorly written hash function, because it easily yields "hash collision"
        // a "hash collision" is when different objects hash to the same value (dumb luck)

        // return getBrand().length() + getVolume();  poorly written

        // delegate to Objects.hash(), which uses a "good" hash function to minimize collisions
        return Objects.hash(getBrand(), getVolume());
    }

    @Override
    public boolean equals(Object obj) {
        boolean result = false;

        // only proceed if 'obj' is a reference to another Television object (EXACT type match)
        if (this.getClass() == obj.getClass()) {
            // downcast 'obj' to more specific Television, so we can call Television methods
            Television other = (Television) obj;

            // do the checks: business equality is defined as brand and volume are the same
            result = Objects.equals(this.getBrand(), other.getBrand()) &&    //null-safe check
                     this.getVolume() == other.getVolume();                  //primitives can't be null
        }
        return result;
    }

    @Override
    public String toString() {
        return "Television: " +
                "brand=" + getBrand() +
                ", volume=" + getVolume() +
                ", currentChannel=" + getCurrentChannel();
    }
}
