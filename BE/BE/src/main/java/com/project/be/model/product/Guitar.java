package com.project.be.model.product;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;

@Entity
public class Guitar {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String bodyWood;

    private String bodyColor;

    private String neckMaterial;

    private String neckCurvature;

    private String scaleLength;

    private String neckInlay;

    private String guitarBridge;

    private String guitarNut;

    private String guitarString;

    private String hardwareFinish;

    private String guitarBag;

    private String numberOfFrets;

    private String guitarPickups;

    private String guitarPickGuards;

    private String tuningMachine;

    private Integer deleteStatus;

    @JsonManagedReference
    @OneToOne
    @JoinColumn(name = "product_id", referencedColumnName = "id")
    private Product product;

    public Guitar() {
    }

    public Guitar(Integer id, String bodyWood,
                  String bodyColor, String neckMaterial,
                  String neckCurvature, String scaleLength,
                  String neckInlay, String guitarBridge,
                  String guitarNut, String guitarString,
                  String hardwareFinish, String guitarBag,
                  String numberOfFrets, String guitarPickups,
                  String guitarPickGuards, String tuningMachine,
                  Integer deleteStatus) {
        this.id = id;
        this.bodyWood = bodyWood;
        this.bodyColor = bodyColor;
        this.neckMaterial = neckMaterial;
        this.neckCurvature = neckCurvature;
        this.scaleLength = scaleLength;
        this.neckInlay = neckInlay;
        this.guitarBridge = guitarBridge;
        this.guitarNut = guitarNut;
        this.guitarString = guitarString;
        this.hardwareFinish = hardwareFinish;
        this.guitarBag = guitarBag;
        this.numberOfFrets = numberOfFrets;
        this.guitarPickups = guitarPickups;
        this.guitarPickGuards = guitarPickGuards;
        this.tuningMachine = tuningMachine;
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

    public String getBodyWood() {
        return bodyWood;
    }

    public void setBodyWood(String bodyWood) {
        this.bodyWood = bodyWood;
    }

    public String getBodyColor() {
        return bodyColor;
    }

    public void setBodyColor(String bodyColor) {
        this.bodyColor = bodyColor;
    }

    public String getNeckMaterial() {
        return neckMaterial;
    }

    public void setNeckMaterial(String neckMaterial) {
        this.neckMaterial = neckMaterial;
    }

    public String getNeckCurvature() {
        return neckCurvature;
    }

    public void setNeckCurvature(String neckCurvature) {
        this.neckCurvature = neckCurvature;
    }

    public String getScaleLength() {
        return scaleLength;
    }

    public void setScaleLength(String scaleLength) {
        this.scaleLength = scaleLength;
    }

    public String getNeckInlay() {
        return neckInlay;
    }

    public void setNeckInlay(String neckInlay) {
        this.neckInlay = neckInlay;
    }

    public String getGuitarBridge() {
        return guitarBridge;
    }

    public void setGuitarBridge(String guitarBridge) {
        this.guitarBridge = guitarBridge;
    }

    public String getGuitarNut() {
        return guitarNut;
    }

    public void setGuitarNut(String guitarNut) {
        this.guitarNut = guitarNut;
    }

    public String getGuitarString() {
        return guitarString;
    }

    public void setGuitarString(String guitarString) {
        this.guitarString = guitarString;
    }

    public String getHardwareFinish() {
        return hardwareFinish;
    }

    public void setHardwareFinish(String hardwareFinish) {
        this.hardwareFinish = hardwareFinish;
    }

    public String getGuitarBag() {
        return guitarBag;
    }

    public void setGuitarBag(String guitarBag) {
        this.guitarBag = guitarBag;
    }

    public String getNumberOfFrets() {
        return numberOfFrets;
    }

    public void setNumberOfFrets(String numberOfFrets) {
        this.numberOfFrets = numberOfFrets;
    }

    public String getGuitarPickups() {
        return guitarPickups;
    }

    public void setGuitarPickups(String guitarPickups) {
        this.guitarPickups = guitarPickups;
    }

    public String getGuitarPickGuards() {
        return guitarPickGuards;
    }

    public void setGuitarPickGuards(String guitarPickGuards) {
        this.guitarPickGuards = guitarPickGuards;
    }

    public String getTuningMachine() {
        return tuningMachine;
    }

    public void setTuningMachine(String tuningMachine) {
        this.tuningMachine = tuningMachine;
    }

    public Integer getDeleteStatus() {
        return deleteStatus;
    }

    public void setDeleteStatus(Integer deleteStatus) {
        this.deleteStatus = deleteStatus;
    }
}
