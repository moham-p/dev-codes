package dev.moham.ss;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class SecurityConfigTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    @WithMockUser(username = "testUser", authorities = {"ALLOWED"})
    public void whenUserWithAllowedAuthority_thenSuccess2() throws Exception {
        mockMvc.perform(get("/allowed"))
                .andExpect(status().isOk());
    }

    @Test
    @WithMockUser(username = "testUser", authorities = {"ROLE_USER"})
    public void whenUserWithoutAllowedAuthority_thenForbidden2() throws Exception {
        mockMvc.perform(get("/restricted-endpoint"))
                .andExpect(status().isForbidden());
    }

    @Test
    @WithMockUser(username = "adminUser", authorities = {"ROLE_ADMIN"})
    public void whenAdminWithoutAllowedAuthority_thenForbidden2() throws Exception {
        mockMvc.perform(get("/restricted-endpoint"))
                .andExpect(status().isForbidden());
    }
}