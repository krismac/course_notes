package com.codeclan.example.FileSystem.projections;

import com.codeclan.example.FileSystem.models.Folder;
import com.codeclan.example.FileSystem.models.User;
import org.springframework.data.rest.core.config.Projection;

import java.util.List;

@Projection(name = "embedFolders", types = User.class)
public interface EmbedFolders {
    public String getName();
    List<Folder> getFolders();
}
