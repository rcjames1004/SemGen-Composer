import java.security.InvalidParameterException;

/**
 * Property for merged models. When a model is
 * merged properties from each model must be mapped and
 * a source property is used. This class takes care of choosing
 * the value from the source property
 * 
 * @author rjames
 *
 */
public class MergedModelProperty implements IModelProperty {

	public IModelProperty _property1;
	public IModelProperty _property2;

	// Property used as the source to retrieve information
	// aobut this merged property
	public IModelProperty _sourceProperty;
	
	public MergedModelProperty(IModelProperty property1, IModelProperty property2){
		if(property1 == null)
			throw new NullPointerException("property1");
		
		if(property2 == null)
			throw new NullPointerException("property2");
		
		_property1 = property1;
		_property2 = property2;
	}
	
	/*
	 * Set the source property
	 */
	public void setSourceProperty(IModelProperty newSourceProperty){
		if(newSourceProperty == null)
			throw new NullPointerException("newSourceProperty");
		
		// Throw and exception if we are trying to set a source property
		// that we don't know about
		if(newSourceProperty != _property1 && newSourceProperty != _property2)
			throw new InvalidParameterException("newSourceProperty");
		
		_sourceProperty = newSourceProperty;
	}
	
	/*
	 * Get the source property
	 */
	public IModelProperty getSourceProperty(){
		return _sourceProperty;
	}
	
	/*
	 * Get property 1
	 */
	public IModelProperty getProperty1(){
		return _property1;
	}
	
	/*
	 * Get property 2
	 */
	public IModelProperty getProperty2(){
		return _property2;
	}
	
	/* 
	 * (non-Javadoc)
	 * @see IModelProperty#getName()
	 */
	@Override
	public String getName() {
		return _sourceProperty == null ? null : _sourceProperty.getName();
	}

	/* (non-Javadoc)
	 * @see IModelProperty#getVariableName()
	 */
	@Override
	public String getVariableName() {
		return _sourceProperty == null ? null : _sourceProperty.getVariableName();
	}

	/* (non-Javadoc)
	 * @see IModelProperty#getEquation()
	 */
	@Override
	public String getEquation() {
		return _sourceProperty == null ? null : _sourceProperty.getEquation();
	}

}
