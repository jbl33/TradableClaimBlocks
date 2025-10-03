TradableClaimBlocks
A powerful Spigot/Paper plugin for Minecraft 1.21.5 that transforms GriefPrevention claim blocks into tradable, physical vouchers, allowing players to exchange and sell their accrued claiming potential.

✨ Features
Claim Block Vouchers: Convert your existing GriefPrevention claim blocks into physical items (vouchers) that can be easily stored, sold, or traded with other players.

Redemption: Vouchers are redeemed simply by right-clicking, instantly crediting the player with the designated number of claim blocks.

Safe Trading: Vouchers are serialized items, preventing fraudulent trading and making them viable for market and chest shops.

Lightweight & Efficient: Built to integrate seamlessly with the required dependency, adding minimal overhead to your server.

⚠️ Requirements (Mandatory Dependency)
This plugin requires the following to function correctly:

GriefPrevention: The latest stable version of the GriefPrevention plugin is required as a core dependency. TradableClaimBlocks relies entirely on GriefPrevention's API for managing player claim blocks.

Minecraft Version: 1.21.5 (Spigot/Paper)

📦 Installation
Ensure you have the latest stable version of GriefPrevention installed and running on your Spigot or Paper server.

Download the TradableClaimBlocks-[VERSION].jar file.

Place the downloaded .jar file into your server's plugins/ directory.

Restart or reload your server.

📜 Commands & Usage
This plugin uses the following commands:

Command

Description

/withdrawclaimblocks <amount>

Converts the specified amount of your claim blocks into a physical voucher item in your inventory.

/claimblocks

Allows the player to check their current GriefPrevention claim blocks count. (Provided by GriefPrevention)

/tradableclaimblocks

Displays plugin information, version, and developer details.

Example Workflow
Withdrawing: A player has 5000 unused claim blocks. They run:

/withdrawclaimblocks 1000

1000 blocks are deducted from their balance, and a "Claim Block Voucher (1000 Blocks)" item appears in their inventory.

Trading: The player sells the voucher to another player in a shop or trades it directly.

Claiming (Redemption): The receiving player right-clicks the voucher item.

The item is consumed, and 1000 claim blocks are instantly added to their GriefPrevention balance.

Found a bug or have a suggestion? Feel free to open an issue or submit a pull request!
