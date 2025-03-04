package pro.frogletwirt.stamper.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pro.frogletwirt.stamper.entities.Role;
import pro.frogletwirt.stamper.repositories.RoleRepository;

@Service
@RequiredArgsConstructor
public class RoleService {
    private final RoleRepository roleRepository;

    public Role getUserRole() {
        return roleRepository.findByName("ROLE_USER").orElseThrow();
    }
}