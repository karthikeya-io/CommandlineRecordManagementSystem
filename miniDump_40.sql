-- MySQL dump 10.13  Distrib 8.0.19, for Win64 (x86_64)
--
-- Host: localhost    Database: mini
-- ------------------------------------------------------
-- Server version	8.0.19

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `anime`
--

DROP TABLE IF EXISTS `anime`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `anime` (
  `id` int NOT NULL,
  `name` varchar(30) DEFAULT NULL,
  `language` varchar(30) DEFAULT NULL,
  `genre` varchar(30) DEFAULT NULL,
  `year` int DEFAULT NULL,
  `type` varchar(30) DEFAULT NULL,
  `rating` decimal(2,1) DEFAULT NULL,
  `productioncompany` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `anime`
--

LOCK TABLES `anime` WRITE;
/*!40000 ALTER TABLE `anime` DISABLE KEYS */;
INSERT INTO `anime` VALUES (1,'Naruto','Sub/Dub','Shounen',2002,'Series',8.0,'Tv Tokyo'),(2,'Death Note','Sub/Dub','Thriller',2006,'Series',8.6,'Madhouse'),(3,'Attack On Titan','Sub/Dub','Action',2013,'Series',9.0,'Wit Studios'),(4,'Demon Slayer: Kimetsu No Yaiba','Sub/Dub','Action',2019,'Series',8.6,'Ufotable'),(5,'Kimetsu No Yaiba: Mugen Train','Sub/Dub','Action',2020,'Movie',8.3,'Ufotable'),(6,'Naruto: Shippuden','Sub/Dub','Shounen',2007,'Series',8.2,'Studio Pierrot'),(7,'Bokura No','Sub','Sci-Fi',2007,'Series',7.6,'Gonzo'),(8,'Your Lie In April','Sub/Dub','Romance',2014,'Series',8.7,'A1-Pictures'),(9,'Tokyo Revengers ','Sub/Dub','Sci-Fi',2021,'Series',8.3,'LidenFilms'),(10,'Your Name','Sub/Dub','Romance',2016,'Movie',8.9,'ComixWave Films');
/*!40000 ALTER TABLE `anime` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `episodes`
--

DROP TABLE IF EXISTS `episodes`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `episodes` (
  `AnimeID` int NOT NULL,
  `EpisodeID` int NOT NULL,
  `EpisodeName` varchar(100) DEFAULT NULL,
  `EpisodeType` varchar(30) DEFAULT NULL,
  `AirDate` date DEFAULT NULL,
  `EpisodeRating` decimal(2,1) DEFAULT NULL,
  PRIMARY KEY (`EpisodeID`),
  KEY `fk_episodes` (`AnimeID`),
  CONSTRAINT `fk_episodes` FOREIGN KEY (`AnimeID`) REFERENCES `anime` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `episodes`
--

LOCK TABLES `episodes` WRITE;
/*!40000 ALTER TABLE `episodes` DISABLE KEYS */;
INSERT INTO `episodes` VALUES (1,1,'Enter: Naruto Uzumaki!','CANON','2002-10-03',7.7),(1,2,'My Name is Konohamaru!','CANON','2002-10-10',7.4),(1,3,'Sasuke and Sakura: Friends or Foes?','CANON','2002-10-17',8.0),(1,4,'Pass or Fail: Survival Test','CANON','2002-10-24',8.9),(1,5,'You Failed! Kakashiâ€™s Final Decision','CANON','2002-10-31',8.9),(1,6,'A Dangerous Mission! Journey to the Land of Waves!','CANON','2002-11-07',7.2),(1,7,'The Assassin of the Mist!','MIXED','2002-11-14',8.2),(1,8,'The Oath of Pain','CANON','2002-11-21',8.3),(1,9,'Kakashi: Sharingan Warrior','MIXED','2002-11-28',8.3),(1,10,'The Forest of Chakra','CANON','2002-12-05',8.9),(1,11,'The Land Where a Hero Once Lived','CANON','2002-12-12',7.4),(1,12,'Battle on the Bridge! Zabuza Returns!!','CANON','2002-12-19',7.8),(1,13,'Hakuâ€™s Secret Jutsu: Crystal Ice Mirrors','CANON','2002-12-21',7.1),(1,14,'\"The Number One Hyperactive\"','MIXED','2002-12-22',8.2),(1,15,'Zero Visibility: The Sharingan Shatters','MIXED','2002-12-23',8.5),(1,16,'The Broken Seal','MIXED','2002-12-24',8.0),(1,17,'White Past: Hidden Ambition','CANON','2002-12-25',7.5),(1,18,'The Weapons Known as Shinobi','MIXED','2003-01-31',7.7),(1,19,'The Demon in the Snow','MIXED','2003-02-13',7.0),(1,20,'A New Chapter Begins: The Chunin Exam!','MIXED','2003-02-20',7.2),(1,21,'Identify Yourself: Powerful New Rivals','MIXED','2003-02-27',7.2),(1,22,'Chunin Challenge: Rock Lee vs. Sasuke!','CANON','2003-03-06',8.5),(1,23,'Genin Takedown! All Nine Rookies Face Off!','MIXED','2003-03-13',7.5),(1,24,'Start Your Engines: The Chunin Exam Begins!','MIXED','2003-03-20',8.0),(1,25,'The Tenth Question: All or Nothing!','CANON','2003-03-27',8.7),(1,26,'Special Report: Live from the Forest of Death!','FILLER','2003-04-02',7.8),(1,27,'The Chunin Exam Stage 2: The Forest of Death','MIXED','2003-04-02',8.2),(1,28,'Eat or be Eaten: Panic in the Forest','MIXED','2003-04-09',8.9),(1,29,'Narutoâ€™s Counterattack: Never Give In!','MIXED','2003-04-16',7.7),(1,30,'The Sharingan Revived: Dragon-Flame Jutsu!','MIXED','2003-04-23',8.6),(1,31,'Bushy Browâ€™s Pledge: Undying Love and Protection!','CANON','2003-05-02',8.6),(1,32,'Sakura Blossoms!','CANON','2003-05-07',8.6),(1,33,'Battle Formation: Ino-Shika-Cho!','CANON','2003-05-14',7.8),(1,34,'Akamaru Trembles: Gaaraâ€™s Cruel Strength!','CANON','2003-05-21',7.5),(1,35,'The Scrollâ€™s Secret: No Peeking Allowed','CANON','2003-05-28',8.9),(1,36,'Clone vs. Clone: Mine are Better than Yours!','CANON','2003-06-04',8.0),(1,37,'Surviving the Cut! The Rookie Nine Together Again!','MIXED','2003-06-11',7.5),(1,38,'Narrowing the Field: Sudden Death Elimination!','MIXED','2003-06-18',8.2),(1,39,'Bushy Browâ€™s Jealousy: Lions Barrage Unleashed!','MIXED','2003-07-02',8.6),(1,40,'Kakashi and Orochimaru: Face-to-Face!','MIXED','2003-07-09',7.5),(1,41,'Kunoichi Rumble: The Rivals Get Serious!','MIXED','2003-07-16',8.5),(1,42,'The Ultimate Battle: Cha!','CANON','2003-07-23',7.9),(1,43,'Killer Kunoichi and a Shaky Shikamaru','MIXED','2003-07-30',7.3),(1,44,'Akamaru Unleashed! Whoâ€™s Top Dog Now?','MIXED','2003-08-06',8.1),(1,45,'Surprise Attack! Narutoâ€™s Secret Weapon!','MIXED','2003-08-13',7.8),(1,46,'Byakugan Battle: Hinata Grows Bold!','MIXED','2003-08-20',8.6),(1,47,'A Failure Stands Tall!','MIXED','2003-08-27',8.8),(1,48,'Gaara vs. Rock Lee: The Power of Youth Explodes!','CANON','2003-09-03',7.5),(1,49,'Leeâ€™s Hidden Strength: Forbidden Secret Jutsu!','MIXED','2003-09-10',7.8),(1,50,'The Fifth Gate: A Splendid Ninja is Born','CANON','2003-09-17',8.4),(1,51,'A Shadow in Darkness: Danger Approaches Sasuke','CANON','2003-09-24',8.0),(1,52,'Ebisu Returns: Narutoâ€™s Toughest Training Yet!','MIXED','2003-10-01',8.2),(1,53,'Long Time No See: Jiraiya Returns!','MIXED','2003-10-08',8.3),(1,54,'The Summoning Jutsu: Wisdom of the Toad Sage!','MIXED','2003-10-15',7.8),(1,55,'\"A Feeling of Yearning A Flower Full of Hope\"','MIXED','2003-10-22',8.5),(1,56,'Live or Die: Risk it All to Win it All!','MIXED','2003-10-29',7.8),(1,57,'He Flies! He Jumps! He Lurks! Chief Toad Appears!','MIXED','2003-11-05',8.4),(1,58,'Hospital Besieged: The Evil Hand Revealed!','MIXED','2003-11-12',7.8),(1,59,'The Final Rounds: Rush to the Battle Arena!','MIXED','2003-11-19',7.4),(1,60,'Byakugan vs. Shadow Clone','MIXED','2003-11-26',8.7),(1,61,'Ultimate Defense: Zero Blind Spot!','CANON','2003-12-03',7.1),(1,62,'A Failureâ€™s True Power','CANON','2003-12-10',7.2),(1,63,'Hit it or Quit it: The Final Rounds Get Complicated!','MIXED','2003-12-17',7.2),(1,64,'Zero Motivation: The Guy with Cloud Envy!','CANON','2003-12-24',8.7),(1,65,'\"Dancing Leaf Squirming Sand\"','CANON','2003-12-31',7.6),(1,66,'Bushy Browâ€™s Jutsu: Sasuke Style!','MIXED','2004-01-14',7.7),(1,67,'\"Late for the Show But Ready to Go!\"','CANON','2004-01-14',8.9),(1,68,'Zero Hour! The Destruction of the Hidden','CANON','2004-01-28',7.8),(1,69,'Village in Distress: A New A-Ranked Mission!','MIXED','2004-02-04',7.8),(1,70,'A Shirkerâ€™s Call to Action: A Layabout No More!','MIXED','2004-02-11',8.4),(1,71,'An Unrivaled Match: Hokage Battle Royale!','MIXED','2004-02-18',8.9),(1,72,'A Mistake from the Past: A Face Revealed!','MIXED','2004-02-25',8.6),(1,73,'Forbidden Secret Technique: Reaper Death Seal!','CANON','2004-03-03',7.3),(1,74,'Astonishing Truth! Gaaraâ€™s Identity Emerges!','MIXED','2004-03-10',7.7),(1,75,'Sasukeâ€™s Decision: Pushed to the Edge!','CANON','2004-03-17',7.5),(1,76,'Assassin of the Moonlit Night','CANON','2004-03-24',8.1),(1,77,'Light vs. Dark: The Two Faces of Gaara','CANON','2004-03-31',7.5),(1,78,'Narutoâ€™s Ninja Handbook','CANON','2004-04-07',8.8),(1,79,'Beyond the Limit of Darkness and Light','CANON','2004-04-14',8.7),(1,80,'\"The Third Hokage Foreverâ€¦\"','CANON','2004-04-21',8.6),(1,81,'Return of the Morning Mist','CANON','2004-04-28',7.5),(1,82,'Eye to Eye: Sharingan vs. Sharingan!','CANON','2004-05-05',8.7),(1,83,'Jiraiya: Narutoâ€™s Potential Disaster!','MIXED','2004-05-12',8.9),(1,84,'\"Roar Chidori! Brother vs. Brother!\"','CANON','2004-05-19',7.1),(1,85,'Hate Among the Uchihas: The Last of the Clan!','CANON','2004-05-26',8.0),(1,86,'A New Training Begins: I Will Be Strong!','CANON','2004-06-02',8.7),(1,87,'Keep on Training: Pop Goes the Water Balloon!','CANON','2004-06-09',8.0),(1,88,'Focal Point: The Mark of the Leaf','CANON','2004-06-16',8.8),(1,89,'An Impossible Choice: The Pain Within Tsunadeâ€™s Heart','CANON','2004-06-23',8.7),(1,90,'Unforgivable! A Total Lack of Respect!','CANON','2004-07-07',8.5),(1,91,'Inheritence! The Necklace of Death!','CANON','2004-07-14',7.0),(1,92,'A Dubious Offer! Tsunadeâ€™s Choice!','CANON','2004-07-21',7.6),(1,93,'Breakdown! The Deal is Off!','CANON','2004-07-28',7.1),(1,94,'Attack! Fury of the Rasengan!','CANON','2004-08-04',8.1),(1,95,'The Fifth Hokage! A Life on the Line!','CANON','2004-08-11',7.9),(1,96,'Deadlock! Sannin Showdown!','CANON','2004-08-11',8.6),(1,97,'Kidnapped! Narutoâ€™s Hot Spring Adventure!','FILLER','2004-08-18',7.5),(1,98,'Tsunadeâ€™s Warning: Ninja No More!','MIXED','2004-08-25',7.0),(1,99,'The Will of Fire Still Burns!','MIXED','2004-09-01',7.7),(1,100,'Sensei and Student: The Bond of the Shinobi','MIXED','2004-09-08',8.3),(1,101,'Gotta See! Gotta Know! Kakashi-Senseiâ€™s True Face!','FILLER','2004-09-15',7.5),(1,102,'Mission: Help an Old Friend in the Land of Tea','FILLER','2004-09-22',8.3),(1,103,'The Race is on! Trouble on the High Seas!','FILLER','2004-09-29',8.8),(1,104,'Run Idate Run! Nagi Island Awaits!','FILLER','2004-10-13',7.2),(1,105,'A Fierce Battle of Rolling Thunder!','FILLER','2004-10-20',7.6),(1,106,'The Last Leg: A Final Act of Desperation','FILLER','2004-10-27',8.9),(1,107,'The Battle Begins: Naruto vs. Sasuke','CANON','2004-11-03',8.8),(1,108,'Bitter Rivals and Broken Bonds','CANON','2004-11-10',8.4),(1,109,'An Invitation from the Sound','CANON','2004-11-17',7.8),(1,110,'Formation! The Sasuke Retrieval Squad','CANON','2004-11-24',8.4),(1,111,'Sound vs. Leaf','CANON','2004-11-24',7.5),(1,112,'Squad Mutiny: Everything Falls Apart!','MIXED','2004-12-01',8.2),(1,113,'\"Full Throttle Power! Choji Ablaze!\"','MIXED','2004-12-08',8.7),(1,114,'Good-bye Old Friendâ€¦! Iâ€™ll Always Believe in You!','MIXED','2004-12-15',7.7),(1,115,'Your Opponent Is Me!','CANON','2004-12-22',7.8),(1,116,'360 Degrees of Vision: The Byakuganâ€™s Blind Spot','CANON','2005-01-05',8.7),(1,117,'Losing is Not an Option!','CANON','2005-01-05',7.4),(1,118,'The Vessel Arrives Too Late','CANON','2005-01-12',7.9),(1,119,'Miscalculation: A New Enemy Appears!','CANON','2005-01-19',8.5),(1,120,'Roar and Howl! The Ultimate Tag Team','CANON','2005-02-02',7.7),(1,121,'To Each His Own Battle','CANON','2005-02-09',7.6),(1,122,'Fakeout: Shikamaruâ€™s Comeback!','CANON','2005-02-16',7.3),(1,123,'The Leafâ€™s Handsome Devil!','CANON','2005-02-23',7.1),(1,124,'The Beast Within','CANON','2005-03-02',8.9),(1,125,'The Sand Shinobi: Allies of the Leaf','CANON','2005-03-09',8.2),(1,126,'Showdown: Gaara vs. Kimimaro!','MIXED','2005-03-16',7.7),(1,127,'Vengeful Strike! The Bracken Dance','MIXED','2005-03-30',7.0),(1,128,'A Cry on Deaf Ears','CANON','2005-03-30',7.0),(1,129,'Brothers: Distance Among the Uchiha','CANON','2005-04-06',7.9),(1,130,'\"Father and Son the Broken Crest\"','MIXED','2005-04-13',8.5),(1,131,'The Secrets of the Mangekyo Sharingan!','MIXED','2005-04-20',7.4),(1,132,'For a Friend','CANON','2005-04-27',8.5),(1,133,'A Plea From a Friend','CANON','2005-05-04',8.9),(1,134,'The End of Tears','CANON','2005-05-11',7.2),(1,135,'The Promise That Could Not Be Kept','CANON','2005-05-18',7.7),(1,136,'Deep Cover!? A Super S-Ranked Mission!','FILLER','2005-05-25',8.7),(1,137,'\"A Town of Outlaws the Shadow of the Fuma Clan\"','FILLER','2005-06-01',8.6),(1,138,'\"Pure Betrayal and a Fleeting Plea!\"','FILLER','2005-06-08',7.5),(1,139,'Pure Terror! The House of Orochimaru','FILLER','2005-06-15',7.5),(1,140,'Two Heartbeats: Kabutoâ€™s Trap','FILLER','2005-06-22',7.1),(1,141,'Sakuraâ€™s Determination','MIXED','2005-06-29',7.3),(1,142,'The Three Villains from the Maximum Security Prison','MIXED','2005-07-06',7.8),(1,143,'Tonton! Iâ€™m Counting on You!','FILLER','2005-07-13',7.3),(1,144,'A New Squad! Two People and a Dog?!','FILLER','2005-07-20',7.6),(1,145,'A New Formation: Ino-Shika-Cho!','FILLER','2005-07-27',8.6),(1,146,'Orochimaruâ€™s Shadow','FILLER','2005-08-10',8.2),(1,147,'A Clash of Fate: You Canâ€™t Bring Me Down','FILLER','2005-08-17',8.0),(1,148,'Search for the Rare Bikochu Beetle','FILLER','2005-08-17',8.9),(1,149,'Whatâ€™s the Difference? Donâ€™t All Insects Look Alike?','FILLER','2005-08-24',8.7),(1,150,'A Battle of Bugs: The Deceivers and the Deceived','FILLER','2005-08-31',8.0),(1,151,'Blaze Away Byakugan: This Is My Ninja Way','FILLER','2005-09-14',8.3),(1,152,'Funeral March for the Living','FILLER','2005-09-21',8.1),(1,153,'A Lesson Learned: The Iron Fist of Love','FILLER','2005-09-28',8.8),(1,154,'The Enemy of the Byakugan','FILLER','2005-10-05',8.1),(1,155,'The Dark Creeping Clouds','FILLER','2005-10-12',7.7),(1,156,'Raigaâ€™s Counterattack','FILLER','2005-10-19',8.4),(1,157,'Run! The Curry of Life','FILLER','2005-10-26',7.5),(1,158,'Follow My Lead! The Great Survival Challenge','FILLER','2005-11-02',8.2),(1,159,'Bounty Hunter from the Wilderness','FILLER','2005-11-09',7.1),(1,160,'Hunt or Be Hunted?! Showdown at the O.K. Temple!','FILLER','2005-11-16',7.2),(1,161,'The Appearance of Strange Visitors','FILLER','2005-11-23',8.5),(1,162,'The Cursed Warrior','FILLER','2005-11-30',8.9),(1,163,'The Tacticianâ€™s Intent','FILLER','2005-12-07',8.6),(1,164,'Too Late for Help','FILLER','2005-12-14',8.4),(1,165,'The Death of Naruto','FILLER','2005-12-21',7.6),(1,166,'When Time Stands Still','FILLER','2006-01-04',8.2),(1,167,'When Egrets Flap Their Wings','FILLER','2006-01-04',8.7),(1,168,'\"Mix It Stretch It Boil It Up! Burn Copper Pot Burn!\"','FILLER','2006-01-18',7.6),(1,169,'Remembrance: The Lost Page','FILLER','2006-01-25',8.3),(1,170,'The Closed Door','FILLER','2006-02-01',7.2),(1,171,'Infiltration: The Set-Up!','FILLER','2006-02-08',9.0),(1,172,'Despair: A Fractured Heart','FILLER','2006-02-15',8.4),(1,173,'The Battle at Sea: The Power Unleashed!','FILLER','2006-02-22',8.8),(1,174,'Impossible! Celebrity Ninja Art â€“ Money Style Jutsu!','FILLER','2006-03-01',8.4),(1,175,'The Treasure Hunt is On!','FILLER','2006-03-08',8.3),(1,176,'\"Run Dodge Zigzag! Chase or Be Chased!\"','FILLER','2006-03-15',7.3),(1,177,'\"Please Mr. Postman!\"','FILLER','2006-03-22',7.7),(1,178,'Encounter! The Boy with a Starâ€™s Name','FILLER','2006-03-29',8.3),(1,179,'The Remembered Lullaby','FILLER','2006-04-05',8.9),(1,180,'Hidden Jutsu: The Price of The Ninja Art: Kujaku','FILLER','2006-04-12',7.3),(1,181,'\"Hoshikage The Buried Truth\"','FILLER','2006-04-19',8.1),(1,182,'\"Reunion The Remaining time\"','FILLER','2006-04-26',9.0),(1,183,'The Starâ€™s Radiance','FILLER','2006-05-03',8.1),(1,184,'Kibaâ€™s Long Day!','FILLER','2006-05-10',8.1),(1,185,'A Legend from the Hidden Leaf: The Onbaa!','FILLER','2006-05-17',8.5),(1,186,'Laughing Shino','FILLER','2006-05-24',8.9),(1,187,'Open for Business! The Leaf Moving Service','FILLER','2006-05-31',7.0),(1,188,'Mystery of the Targeted Merchants','FILLER','2006-06-07',7.3),(1,189,'A Limitless Supply of Ninja Tools','FILLER','2006-06-14',8.5),(1,190,'The Byakugan Sees the Blind Spot','FILLER','2006-06-21',7.8),(1,191,'Forecast: Death! Cloudy with Chance of Sun','FILLER','2006-06-28',7.8),(1,192,'Ino Screams! Chubby Paradise!','FILLER','2006-07-05',8.5),(1,193,'Viva Dojo Challenge! Youth Is All About Passion!','FILLER','2006-07-12',8.9),(1,194,'The Mysterious Curse of the Haunted Castle','FILLER','2006-07-19',7.4),(1,195,'The Third Super-Beast!','FILLER','2006-07-26',7.0),(1,196,'Hot-Blooded Confrontation: Student vs. Sensei','FILLER','2006-08-09',8.8),(1,197,'Crisis! The Hidden Leaf 11 Gather!','FILLER','2006-08-16',8.3),(1,198,'The ANBU Gives Up? Narutoâ€™s Recollection','FILLER','2006-08-23',7.1),(1,199,'The Missed Target','FILLER','2006-08-30',8.1),(1,200,'The Powerful Helper','FILLER','2006-09-13',7.5),(1,201,'Multiple Traps! Countdown to Destruction','FILLER','2006-09-20',7.4),(1,202,'The Top 5 Ninja Battles','FILLER','2006-09-27',8.8),(1,203,'\"Kurenaiâ€™s Decision Squad 8 Left Behind\"','FILLER','2006-10-05',7.5),(1,204,'Yakumoâ€™s Sealed Ability','FILLER','2006-10-05',7.9),(1,205,'Kurenaiâ€™s Top-Secret Mission: The Promise','FILLER','2006-10-05',7.5);
/*!40000 ALTER TABLE `episodes` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `movies`
--

DROP TABLE IF EXISTS `movies`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `movies` (
  `AnimeID` int NOT NULL,
  `MovieID` int NOT NULL,
  `MovieName` varchar(100) DEFAULT NULL,
  `ReleaseDate` date DEFAULT NULL,
  `Director` varchar(30) DEFAULT NULL,
  `Duration` int DEFAULT NULL,
  `MovieRating` decimal(2,1) DEFAULT NULL,
  PRIMARY KEY (`MovieID`),
  KEY `fk_movies` (`AnimeID`),
  CONSTRAINT `fk_movies` FOREIGN KEY (`AnimeID`) REFERENCES `anime` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `movies`
--

LOCK TABLES `movies` WRITE;
/*!40000 ALTER TABLE `movies` DISABLE KEYS */;
INSERT INTO `movies` VALUES (1,1,'Ninja Clash in the Land of Snow','2004-08-21','Tensai Okamura',83,6.7),(1,2,'Legend of the Stone of Gelel','2005-06-08','Hirotsugu Kawasaki',97,6.6),(1,3,'Guardians of the Crescent Moon Kingdom','2006-05-08','Toshiyuki Tsuru',95,6.5),(6,4,'Naruto Shippuden: The Movie','2007-04-08','Hajime Kamegaki',95,6.9),(6,5,'Bonds','2008-02-08','Hajime Kamegaki',93,7.1),(6,6,'The Will Of Fire','2009-01-08','Masahiko Murata',96,7.2),(6,7,'The Lost Tower','2010-07-31','Masahiko Murata',85,7.1),(6,8,'Blood Prison','2011-07-21','Masahiko Murata',103,7.3),(6,9,'Road to Ninja','2012-07-28','Hayato Date',109,7.7),(6,10,'The Last','2014-06-12','Tsuneo Kobayashi',112,7.6),(5,11,'Mugen Train','2021-04-23','Koyoharu Gotouge',117,8.2);
/*!40000 ALTER TABLE `movies` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-12-05 22:14:32
