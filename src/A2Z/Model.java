package A2Z;

import java.util.*;

/**
 * 
 */
public class Model {

    /**
     * Default constructor
     */
    public Model() {
    }

    public Model(String modelID, String name, Brand brand) {
        this.modelID = modelID;
        this.name = name;
        this.brand = brand;
        views = 0;
    }

    /**
     *

     */
    private String modelID;

    /**
     * 
     */
    private String name;

    /**
     * 
     */
    private Brand brand;

    /**
     * 
     */
    private int views;




}