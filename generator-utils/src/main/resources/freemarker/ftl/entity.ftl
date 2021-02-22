package ${entityUrl};
<#if isSwagger=="true" >
import io.swagger.annotations.ApiModelProperty;
</#if>
import lombok.Data;
import java.io.Serializable;
<#list pkgs as ps>
	<#if ps??>
import ${ps};
	</#if>
</#list>

/**
 * 
 * <p>说明： ${entityComment}实体类</P>
 * @version: ${version}
 * @author: ${author}
 * 
 */
@Data
public class ${entityName} implements Serializable {

	private static final long serialVersionUID = ${agile}L;
	
<#list cis as ci>
 <#if isSwagger=="true" >
	@ApiModelProperty(name = "${ci.property}" , value = "${ci.comment}")
 </#if>
	private ${ci.javaType} ${ci.property};
    
</#list>


}
	