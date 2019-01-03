package com.codeclan.example.FileSystem.repositories;

import com.codeclan.example.FileSystem.projections.EmbedFolders;
import com.codeclan.example.FileSystem.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

@Repository
@RepositoryRestResource(excerptProjection = EmbedFolders.class)
public interface UserRepository extends JpaRepository<User, Long> {
}
