package examples.component.repository;

import examples.entity.OrganizationModel;
import examples.orm.mapper.OrganizationMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class OrganizationDAO {
    @Autowired
    private OrganizationMapper organizationMapper;

    public OrganizationDAO() {
        super();
    }

    @Transactional(readOnly=true)
    public OrganizationModel getOrganization(String organizationId){
        return this.organizationMapper.getOrganization(organizationId);
    }

    @Transactional(readOnly=true)
    public List<OrganizationModel> findAll(){
        return this.organizationMapper.findAll();
    }

    @Transactional
    public void entryOrganization(OrganizationModel organizationModel){
        this.organizationMapper.entryOrganization(organizationModel);
    }
}
