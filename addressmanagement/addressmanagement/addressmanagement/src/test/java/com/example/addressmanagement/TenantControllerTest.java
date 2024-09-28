package com.example.addressmanagement;


import Controllers.TenantController;
import Entity.Tenant;
import Services.TenantService;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(TenantController.class)
public class TenantControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Mock
    private TenantService tenantService;

    @InjectMocks
    private TenantController tenantController;

    @Test
    public void testGetAllTenants() throws Exception {
        MockitoAnnotations.openMocks(this);

        mockMvc.perform(get("/api/tenants"))
                .andExpect(status().isOk());
    }

    @Test
    public void testGetTenantById() throws Exception {
        MockitoAnnotations.openMocks(this);

        mockMvc.perform(get("/api/tenants/1"))
                .andExpect(status().isOk());
    }

    @Test
    public void testCreateTenant() throws Exception {
        MockitoAnnotations.openMocks(this);

        Tenant tenant = new Tenant();
        tenant.setName("New Tenant");

        mockMvc.perform(post("/api/tenants")
                        .contentType("application/json")
                        .content("{\"name\": \"New Tenant\"}"))
                .andExpect(status().isOk());
    }

    @Test
    public void testUpdateTenant() throws Exception {
        MockitoAnnotations.openMocks(this);

        mockMvc.perform(put("/api/tenants/1")
                        .contentType("application/json")
                        .content("{\"name\": \"Updated Tenant\"}"))
                .andExpect(status().isOk());
    }

    @Test
    public void testDeleteTenant() throws Exception {
        MockitoAnnotations.openMocks(this);

        mockMvc.perform(delete("/api/tenants/1"))
                .andExpect(status().isNoContent());
    }
}
