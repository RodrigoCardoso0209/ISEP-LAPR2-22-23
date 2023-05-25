package pt.ipp.isep.dei.esoft.project.domain;

import java.util.Objects;
import java.util.List;

/**
 * The type Property.
 */
public class Land implements Property {

    private String type;
    private double area;
    private String location;

    private double distance;

    private List<String> photos;

    private Owner owner;






    public Land(double area, double distance, double photos) {
        if (area <= 0) {
            throw new IllegalArgumentException("Area must be greater than 0.");
        }
        if (distance <= 0) {
            throw new IllegalArgumentException("Distance from the city center must be greater than 0.");
        }
        /*if (photos == null) {
            throw new IllegalArgumentException("Is necessary more than 0 photos");
        }*/

    }

    /**
     * Instantiates a new Property.
     *
     * @param area     the area
     * @param distance the distance
     */
    public Land(int area, int distance) {
        this.area = area;
        this.distance = distance;
    }

    /**
     * Instantiates a new Property.
     *
     * @param location the property location

     */
    public Land(String location) {
        this.location = location;
    }



    /**
     * Gets area.
     *
     * @return the area
     */
    public double getArea() {
        return area;
    }

    /**
     * Sets area.
     *
     * @param area the area
     */
    public void setArea(int area) {
        this.area = area;
    }

    /**
     * Sets distance.
     *
     * @param distance the distance
     */
    public void setDistance(int distance) {
        this.distance = distance;
    }

    /**
     * Gets distance.
     *
     * @return the distance
     */
    public double getDistance() {
        return distance;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Land land = (Land) o;
        return area == land.area && distance == land.distance && Objects.equals(location, land.location) && Objects.equals(photos, land.photos);
    }

    @Override
    public int hashCode() {
        return Objects.hash(area, location, distance, photos);
    }

    /**
     * Instantiates a new Property.
     *
     * @param area     the area
     * @param location the location
     * @param distance the distance
     */
    public Land(String type, double area, String location, double distance, List<String> photos, Owner owner) {
        this.type = type;
        this.area = area;
        if (location == null) {
            throw new NullPointerException("Invalid address. This must not be null.");
        }
        this.location = location;
        this.distance = distance;
        this.photos = photos;
        this.owner = owner;
    }

    public Land(String type, double area, String location, double distance, Owner owner){
        this.type = type;
        this.area = area;
        if (location == null) {
            throw new NullPointerException("Invalid address. This must not be null.");
        }
        this.location = location;
        this.distance = distance;
        this.owner = owner;
    }

    public Land clone() {
        return new Land(this.type, this.area, this.location, this.distance, this.photos, this.owner);
    }

    @Override
    public PropertyType getType() {
        return null;
    }

    /**
     * Gets location.
     *
     * @return the location
     */
    public String getLocation() {
        return location;
    }

    public void setPhotos(Object o) {
    }

    public String toString() {
        return String.format("Type: %s%n" +
                "Area: %.2f%n" +
                "Location: %s%n" +
                "Distance from City Centre: %.2f%n", type, area, location, distance);
    }




}