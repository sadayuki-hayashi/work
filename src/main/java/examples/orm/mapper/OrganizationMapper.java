package examples.orm.mapper;

import examples.entity.OrganizationModel;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface OrganizationMapper {
    public OrganizationModel getOrganization(@Param("organization_id") String organizationId);

    public List<OrganizationModel> findAll();

    public void entryOrganization(OrganizationModel organizationModel);
}

