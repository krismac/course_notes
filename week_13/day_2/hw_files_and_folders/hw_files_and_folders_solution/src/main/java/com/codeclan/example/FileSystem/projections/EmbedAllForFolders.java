package com.codeclan.example.FileSystem.projections;

import com.codeclan.example.FileSystem.models.File;
import com.codeclan.example.FileSystem.models.Folder;
import com.codeclan.example.FileSystem.models.User;
import org.springframework.data.rest.core.config.Projection;

import java.util.List;

@Projection(name = "embedAllForFolders", types = Folder.class)
public interface EmbedAllForFolders {
    public String getTitle();
    public User getUser();
    public List<File> getFiles();
}
