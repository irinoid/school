package hogwarts.school.interfaces;

import hogwarts.school.model.Avatar;
import org.springframework.web.multipart.MultipartFile;
import java.io.IOException;
import java.util.List;

public interface AvatarService {
    void uploadAvatar(Long studentId, MultipartFile avatarFile) throws IOException;
    Avatar findAvatar(Long studentId);
    List<Avatar> findAll(int pageNumber, int pageSize);
}
