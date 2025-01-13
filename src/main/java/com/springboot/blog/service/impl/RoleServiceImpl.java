package com.springboot.blog.service.impl;

import com.springboot.blog.entity.Role;
import com.springboot.blog.payload.RoleDto;
import com.springboot.blog.repository.RoleRepository;
import com.springboot.blog.service.RoleService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RoleServiceImpl implements RoleService {

    private final RoleRepository roleRepository;
    private final ModelMapper mapper;

    @Override
    public RoleDto createRole(RoleDto roleDto) {

        Role role = mapper.map(roleDto, Role.class); //roleRepository.findByName(roleDto.getName())
                //.orElseThrow(() -> new BlogException(HttpStatus.BAD_REQUEST, "Role Already exist"));

        return mapper.map(roleRepository.save(role), RoleDto.class);
    }
}
