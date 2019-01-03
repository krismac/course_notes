package com.codeclan.example.FileSystem.repositories;

import com.codeclan.example.FileSystem.models.File;
import com.codeclan.example.FileSystem.projections.EmbedFolderForFile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

@Repository
@RepositoryRestResource(excerptProjection = EmbedFolderForFile.class)
public interface FileRepository extends JpaRepository<File, Long> {
}
