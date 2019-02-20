package FairGrounds.Application;

import FairGrounds.Domain.*;
import FairGrounds.Repository.ApplicationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;


@Transactional(rollbackFor = Exception.class, propagation = Propagation.REQUIRES_NEW)
@Service
public class ApplicationSearchService {

    @Autowired
    private ApplicationRepository applicationRepository;

    public Page<Application> getQueriedApplications(String name, String expertise, Date appDate,
                                                       Date workFrom, Date workTo, Pageable pageable) {

        return this.applicationRepository.findAll(name, expertise, appDate, workFrom, workTo, pageable);
    }
}
