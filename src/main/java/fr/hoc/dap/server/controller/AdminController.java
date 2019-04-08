package fr.hoc.dap.server.controller;

import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.google.api.client.auth.oauth2.StoredCredential;
import com.google.api.client.util.store.DataStore;

import fr.hoc.dap.server.service.AdminService;

@Controller
public class AdminController {

    @Autowired
    private AdminService admservice;

    @RequestMapping("/admin")
    public String displayUser(ModelMap model) throws IOException, GeneralSecurityException {

        DataStore<StoredCredential> donnee = admservice.getDataStore();
        Map<String, StoredCredential> userMap = new HashMap<>();
        Set<String> allKeys = donnee.keySet();
        System.err.println(allKeys);
        for (String aKey : allKeys) {
            StoredCredential value = donnee.get(aKey);
            userMap.put(aKey, value);
        }
        System.err.println(userMap);
        model.addAttribute("users", userMap);
        return "admin";

    }
}