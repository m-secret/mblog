package club.msecret.mblog.service;

import java.util.List;

import club.msecret.mblog.entity.Archive;

public interface ArchiveService {
    List<Archive> findAll();
}
