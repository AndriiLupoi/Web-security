package org.lupoi.security25;/*
    @author Andrii
    @project security25
    @class AccessTests
    @version 1.0.0
    @since 29.10.2025 - 12.55
*/

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.test.context.support.WithAnonymousUser;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;


import static org.springframework.security.test.web.servlet.setup.SecurityMockMvcConfigurers.springSecurity;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@ExtendWith(SpringExtension.class)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@ActiveProfiles("test")
public class AccessTests {

    @Autowired
    private WebApplicationContext webApplicationContext;

    private MockMvc mockMvc;

    @BeforeAll
    void beforeAll(){
        this.mockMvc = MockMvcBuilders
                .webAppContextSetup(this.webApplicationContext)
                .apply(springSecurity())
                .build();
    }


    @Test
    @WithAnonymousUser
    public void whenAnonymThenStatusUnautorized() throws Exception {

        mockMvc.perform(get("/api/v1/users"))
                .andExpect(status()
                        .isUnauthorized());
    }

    @Test
    @WithMockUser(username = "admin", password = "admin", roles = {"ADMIN"})
    void whenAuthenticatedThenStatusIsOk() throws Exception {
        mockMvc.perform(get("/api/v1/users/hello/admin"))
                .andExpect(status().isOk());
    }

    @Test
    @WithMockUser(username = "admin", password = "admin", roles = {"ADMIN"})
    void whenAuthenticatedThenStatusIsForbidden() throws Exception {
        mockMvc.perform(get("/api/v1/users/hello/user"))
                .andExpect(status().isForbidden());
    }

    @Test
    @WithAnonymousUser
    void whenAnonymGetByIdThenStatusUnauthorized() throws Exception {
        mockMvc.perform(get("/api/v1/users/1"))
                .andExpect(status().isUnauthorized());
    }

    @Test
    @WithMockUser(username = "user", password = "user", roles = {"USER"})
    void whenUserGetByIdThenStatusForbidden() throws Exception {
        mockMvc.perform(get("/api/v1/users/1"))
                .andExpect(status().isForbidden());
    }

    @Test
    @WithAnonymousUser
    void whenAnonymDeleteThenStatusUnauthorized() throws Exception {
        mockMvc.perform(delete("/api/v1/users/1"))
                .andExpect(status().isUnauthorized());
    }

    @Test
    @WithMockUser(username = "admin", roles = {"ADMIN"})
    void whenAdminDeleteThenStatusForbidden() throws Exception {
        mockMvc.perform(delete("/api/v1/users/1"))
                .andExpect(status().isForbidden());
    }

    @Test
    @WithMockUser(username = "superadmin", password = "superadmin", roles = {"SUPERADMIN"})
    void whenSuperadminDeleteThenStatusOk() throws Exception {
        mockMvc.perform(delete("/api/v1/users/1"))
                .andExpect(status().isOk());
    }

    @Test
    @WithMockUser(username = "user", password = "user", roles = {"USER"})
    void whenAuthenticatedUserThenStatusOk() throws Exception {
        mockMvc.perform(get("/api/v1/users/hello/user"))
                .andExpect(status().isOk());
    }

    @Test
    @WithMockUser(username = "user", password = "user", roles = {"USER"})
    void whenAuthenticatedUserThenStatusIsOk() throws Exception {
        mockMvc.perform(get("/api/v1/users/hello/user"))
                .andExpect(status().isOk());
    }

    @Test
    @WithAnonymousUser
    void whenAnonymHelloStrangerThenStatusIsUnauthorized() throws Exception {
        mockMvc.perform(get("/api/v1/users/hello/stranger"))
                .andExpect(status().isUnauthorized());
    }

    @Test
    @WithAnonymousUser
    void whenAnonymHelloUnknownThenStatusUnauthorized() throws Exception {
        mockMvc.perform(get("/api/v1/users/hello/unknown"))
                .andExpect(status().isUnauthorized());
    }

}
