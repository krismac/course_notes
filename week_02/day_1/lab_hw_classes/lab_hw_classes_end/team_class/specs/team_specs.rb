require('minitest/autorun')
require('minitest/rg')
require_relative('../team')

class TeamTest < MiniTest::Test

  def setup()
    players = ["Derice Bannock", "Sanka Coffie", "Junior Bevil", "Yul Brenner"]
    @team = Team.new("Cool Runnings", players, "Irv Blitzer")
  end

  def test_team_has_name()
    assert_equal("Cool Runnings", @team.team_name())
  end

  def test_team_has_players()
    assert_equal(4, @team.players().count())
  end

  def test_team_has_coach()
    assert_equal("Irv Blitzer", @team.coach())
  end

  def test_check_team_has_points()
    assert_equal(0, @team.points())
  end

  def test_coach_can_be_updated()
    @team.coach = "John Candy"
    assert_equal("John Candy", @team.coach())
  end

  def test_new_player_can_be_added()
    new_player = "Jeff"
    @team.add_player(new_player)
    assert_equal(5, @team.players().count())
    # Other options added in review
    assert_equal(new_player, @team.players().last())
    expected = [
      "Derice Bannock",
      "Sanka Coffie",
      "Junior Bevil",
      "Yul Brenner",
      "Jeff"
    ]
    assert_equal(expected, @team.players())
    assert(@team.players().include?(new_player))
  end

  def test_check_player_in_team__found()
    assert_equal(true, @team.has_player?("Junior Bevil"))
  end

  def test_check_player_in_team__not_found()
    assert_equal(false, @team.has_player?("Usain Bolt"))
  end

  def test_play_game__win()
    @team.play_game(true)
    assert_equal(3, @team.points())
  end

  def test_play_game__lose()
    @team.play_game(false)
    assert_equal(0, @team.points())
  end

  def test_add_multiple_players()
    @team.add_many(["Craig Morton", "Nyalls Hemingway"])
    expected = [
      "Derice Bannock",
      "Sanka Coffie",
      "Junior Bevil",
      "Yul Brenner",
      "Craig Morton",
      "Nyalls Hemingway"
    ]
    assert_equal(expected, @team.players)
  end

end
