class Instrument

  attr_reader :type

  def initialize(type)
    @type = type
  end

  def make_sound(title)
    if @type == "piano"
      return "Plink plonk... I'm playing #{title}!"
    else
      return "I'm playing #{title}!"
    end
  end

end
