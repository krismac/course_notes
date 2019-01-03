package com.codeclan.example.FileSystem.repositories;

import com.codeclan.example.FileSystem.models.Folder;
import com.codeclan.example.FileSystem.projections.EmbedAllForFolders;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

@Repository
@RepositoryRestResource(excerptProjection = EmbedAllForFolders.class)
public interface FolderRepository extends JpaRepository<Folder, Long> {

}
