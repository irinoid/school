package hogwarts.school.service;

import hogwarts.school.interfaces.InfoService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class InfoServiceImpl implements InfoService {
    @Value("${server.port}")
    private int portNumber;

    @Override
    public int getCurrentPort() {
        return portNumber;
    }
}
