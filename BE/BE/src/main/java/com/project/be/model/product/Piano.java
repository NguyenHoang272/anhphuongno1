package com.project.be.model.product;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;

@Entity
public class Piano {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String numberOfKeys;

    private String keySensitivity;

    private String pianoSound;

    private String maxPolyphony;

    private String numberOfSounds;

    private String pianoEffect;

    private String pianoFunction;

    private String pianoMetronome;

    private String pianoTranspose;

    private String pianoTuning;

    private String connectMethod;

    private String pianoAmp;

    private String pianoSpeaker;

    private String energyConsumption;

    private String pianoAccessories;

    private String pianoSize;

    private String pianoWeight;

    private String deleteStatus;

    @JsonManagedReference
    @OneToOne
    @JoinColumn(name = "product_id", referencedColumnName = "id")
    private Product product;

    public Piano() {
    }

    public Piano(Integer id,
                 String numberOfKeys, String keySensitivity,
                 String pianoSound, String maxPolyphony,
                 String numberOfSounds, String pianoEffect,
                 String pianoFunction, String pianoMetronome,
                 String pianoTranspose, String pianoTuning,
                 String connectMethod, String pianoAmp,
                 String pianoSpeaker, String energyConsumption,
                 String pianoAccessories, String pianoSize,
                 String pianoWeight, String deleteStatus) {
        this.id = id;
        this.numberOfKeys = numberOfKeys;
        this.keySensitivity = keySensitivity;
        this.pianoSound = pianoSound;
        this.maxPolyphony = maxPolyphony;
        this.numberOfSounds = numberOfSounds;
        this.pianoEffect = pianoEffect;
        this.pianoFunction = pianoFunction;
        this.pianoMetronome = pianoMetronome;
        this.pianoTranspose = pianoTranspose;
        this.pianoTuning = pianoTuning;
        this.connectMethod = connectMethod;
        this.pianoAmp = pianoAmp;
        this.pianoSpeaker = pianoSpeaker;
        this.energyConsumption = energyConsumption;
        this.pianoAccessories = pianoAccessories;
        this.pianoSize = pianoSize;
        this.pianoWeight = pianoWeight;
        this.deleteStatus = deleteStatus;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNumberOfKeys() {
        return numberOfKeys;
    }

    public void setNumberOfKeys(String numberOfKeys) {
        this.numberOfKeys = numberOfKeys;
    }

    public String getKeySensitivity() {
        return keySensitivity;
    }

    public void setKeySensitivity(String keySensitivity) {
        this.keySensitivity = keySensitivity;
    }

    public String getPianoSound() {
        return pianoSound;
    }

    public void setPianoSound(String pianoSound) {
        this.pianoSound = pianoSound;
    }

    public String getMaxPolyphony() {
        return maxPolyphony;
    }

    public void setMaxPolyphony(String maxPolyphony) {
        this.maxPolyphony = maxPolyphony;
    }

    public String getNumberOfSounds() {
        return numberOfSounds;
    }

    public void setNumberOfSounds(String numberOfSounds) {
        this.numberOfSounds = numberOfSounds;
    }

    public String getPianoEffect() {
        return pianoEffect;
    }

    public void setPianoEffect(String pianoEffect) {
        this.pianoEffect = pianoEffect;
    }

    public String getPianoFunction() {
        return pianoFunction;
    }

    public void setPianoFunction(String pianoFunction) {
        this.pianoFunction = pianoFunction;
    }

    public String getPianoMetronome() {
        return pianoMetronome;
    }

    public void setPianoMetronome(String pianoMetronome) {
        this.pianoMetronome = pianoMetronome;
    }

    public String getPianoTranspose() {
        return pianoTranspose;
    }

    public void setPianoTranspose(String pianoTranspose) {
        this.pianoTranspose = pianoTranspose;
    }

    public String getPianoTuning() {
        return pianoTuning;
    }

    public void setPianoTuning(String pianoTuning) {
        this.pianoTuning = pianoTuning;
    }

    public String getConnectMethod() {
        return connectMethod;
    }

    public void setConnectMethod(String connectMethod) {
        this.connectMethod = connectMethod;
    }

    public String getPianoAmp() {
        return pianoAmp;
    }

    public void setPianoAmp(String pianoAmp) {
        this.pianoAmp = pianoAmp;
    }

    public String getPianoSpeaker() {
        return pianoSpeaker;
    }

    public void setPianoSpeaker(String pianoSpeaker) {
        this.pianoSpeaker = pianoSpeaker;
    }

    public String getEnergyConsumption() {
        return energyConsumption;
    }

    public void setEnergyConsumption(String energyConsumption) {
        this.energyConsumption = energyConsumption;
    }

    public String getPianoAccessories() {
        return pianoAccessories;
    }

    public void setPianoAccessories(String pianoAccessories) {
        this.pianoAccessories = pianoAccessories;
    }

    public String getPianoSize() {
        return pianoSize;
    }

    public void setPianoSize(String pianoSize) {
        this.pianoSize = pianoSize;
    }

    public String getPianoWeight() {
        return pianoWeight;
    }

    public void setPianoWeight(String pianoWeight) {
        this.pianoWeight = pianoWeight;
    }

    public String getDeleteStatus() {
        return deleteStatus;
    }

    public void setDeleteStatus(String deleteStatus) {
        this.deleteStatus = deleteStatus;
    }
}
