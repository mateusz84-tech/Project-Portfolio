package pl.matkoc.Approval_material;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import pl.matkoc.Approval_material.domain.model.Material;

@SpringBootApplication
public class ApprovalMaterialApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApprovalMaterialApplication.class, args);

		Material user = new Material();
		
	}

}
