package com.optimagrowth.licensingservice.service;

import com.optimagrowth.licensingservice.model.License;
import java.util.Optional;
import java.util.concurrent.ThreadLocalRandom;
import org.springframework.stereotype.Service;

@Service
public class LicenseService {

    public License getLicense(String licenseId, String organizationId) {
        var license = new License();
        license.setId(ThreadLocalRandom.current().nextInt(1000));
        license.setLicenseId(licenseId);
        license.setOrganizationId(organizationId);
        license.setDescription("Software product");
        license.setProductName("Ostock");
        license.setLicenseType("full");
        return license;
    }

    public String createLicense(License license, String organizationId) {
        return Optional.ofNullable(license)
            .map(l -> {
                l.setOrganizationId(organizationId);
                return String.format("This is the post and the object is: %s", license);
            })
            .orElse(null);
    }

    public String updateLicense(License license, String organizationId) {
        return Optional.ofNullable(license)
            .map(l -> {
                l.setOrganizationId(organizationId);
                return String.format("This is the put and the object is: %s", license);
            })
            .orElse(null);
    }

    public String deleteLicense(String licenseId, String organizationId) {
        return String.format("Deleting license with id %s for the organization %s", licenseId, organizationId);
    }

}
