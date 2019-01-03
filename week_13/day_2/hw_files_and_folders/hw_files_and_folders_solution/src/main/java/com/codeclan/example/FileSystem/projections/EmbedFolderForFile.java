package com.codeclan.example.FileSystem.projections;

import com.codeclan.example.FileSystem.models.File;
import com.codeclan.example.FileSystem.models.Folder;
import org.springframework.data.rest.core.config.Projection;

@Projection(name = "embedAllForFolders", types = File.class)
public interface EmbedFolderForFile {
    public String getName();
    public String getExtension();
    public int getSize();
    public Folder getFolder();

}
