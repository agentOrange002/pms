package sys.app.pms.entity;

import java.io.Serializable;

import lombok.Data;

@SuppressWarnings("serial")
@Data
public class User implements Serializable {
	/**
	 * 
	 */

	private Long userId;
	private String name;
}
