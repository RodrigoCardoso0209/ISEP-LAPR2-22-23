package pt.ipp.isep.dei.esoft.project.domain;

import java.util.Objects;
import java.util.List;

/**
 * The type Property.
 */
public class Property {

    private PropertyType type;
    private double area;
    private Location location;

    private double distance;

    private List<String> photos;

    private Owner owner;

    private static final String initialString = "n/a";


    /**
     * Instantiates a new Property.
     *
     * @param area
     * @param distance
     * @param photos
     */
    public Property(double area,double distance, List<String> photos) {
        if (area <= 0) {
            throw new IllegalArgumentException("Area must be greater than 0.");
        }
        if (distance <= 0) {
            throw new IllegalArgumentException("Distance from the city center must be greater than 0.");
        }
        if (photos == null) {
            throw new IllegalArgumentException("Is necesssary more than 0 photos");
        }

    }

    /**
     * Instantiates a new Property.
     *
     * @param area     the area
     * @param distance the distance
     */
    public Property(int area, int distance) {
        this.area = area;
        this.distance = distance;
    }

    public Property(double area) {
        this.area = area;
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
        Property property = (Property) o;
        return area == property.area && distance == property.distance && Objects.equals(location, property.location) && Objects.equals(photos, property.photos);
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
     * @param owner
     */

    public Property(PropertyType type, double area, Location location, double distance, Owner owner) {
        this.type = type;
        this.area = area;
        if (location == null) {
            throw new NullPointerException("Invalid address. This must not be null.");
        }
        this.location = location;
        this.distance = distance;
    }


    public Property clone() {
        return new Property(this.type, this.area, this.location, this.distance, owner);
    }

    /**
     * Gets location.
     *
     * @return the location
     */
    public Location getLocation() {
        return location;
    }

    /*public void setPhotos(Object o) {
    }*/

    @Override
    public String toString() {
        return "\nType: " + type +
                "\nArea: " + area + "m2"+
                "\nLocation: " + location +
                "\nDistance of city centre: " + distance + "m" ;
    }
}
