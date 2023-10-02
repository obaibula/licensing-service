package com.optimagrowth.license.service;

import com.optimagrowth.license.model.License;
import java.util.Locale;
import java.util.Optional;
import java.util.concurrent.ThreadLocalRandom;
import lombok.RequiredArgsConstructor;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LicenseService {

    private final MessageSource messages;

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

    public String createLicense(License license, String organizationId, Locale locale) {
        return Optional.ofNullable(license)
            .map(l -> {
                l.setOrganizationId(organizationId);
                return String.format(
                    messages.getMessage("license.create.message", null, locale),
                    l);
            })
            .orElse(null);
    }

    public String updateLicense(License license, String organizationId) {
        return Optional.ofNullable(license)
            .map(l -> {
                l.setOrganizationId(organizationId);
                return String.format(
                    messages.getMessage("license.update.message", null, null),
                    l);
            })
            .orElse(null);
    }

    public String deleteLicense(String licenseId, String organizationId) {
        return String.format("Deleting license with id %s for the organization %s", licenseId, organizationId);
    }

}
