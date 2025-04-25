#!/bin/bash

# This script helps push your project to GitHub
# Usage: ./github_push.sh <github_username> <email> <repository_url>

if [ "$#" -ne 3 ]; then
    echo "Usage: ./github_push.sh <github_username> <email> <repository_url>"
    echo "Example: ./github_push.sh johndoe john.doe@example.com https://github.com/johndoe/a1channel.git"
    exit 1
fi

USERNAME=$1
EMAIL=$2
REPO_URL=$3

echo "Creating a public GitHub repository..."

# Check if git is installed
if ! command -v git &> /dev/null; then
    echo "Git is not installed. Please install Git first."
    exit 1
fi

# Check if GitHub CLI is installed (for automatic repository creation)
if command -v gh &> /dev/null; then
    echo "GitHub CLI detected, attempting to create repository automatically..."
    
    # Check if logged in to GitHub CLI
    if ! gh auth status &> /dev/null; then
        echo "Please login to GitHub CLI first with: gh auth login"
        exit 1
    fi
    
    # Create the repository
    gh repo create a1channel --description "A1Channel Product Management System with Premium UI" --public
    if [ $? -eq 0 ]; then
        echo "Repository created successfully!"
        REPO_URL="https://github.com/$USERNAME/a1channel.git"
    else
        echo "Failed to create repository automatically. Please create it manually."
        exit 1
    fi
else
    echo "GitHub CLI not detected. Please create the repository manually on GitHub."
    echo "Then run this script again or follow the steps in the github_upload_instructions.md file."
    exit 1
fi

# Initialize git repository if not already initialized
if [ ! -d .git ]; then
    git init
    echo "Git repository initialized."
fi

# Configure git
git config user.name "$USERNAME"
git config user.email "$EMAIL"

# Add all files
git add .

# Commit
git commit -m "Initial commit"

# Add remote origin
git remote add origin $REPO_URL || git remote set-url origin $REPO_URL

# Push to GitHub
git push -u origin main || git push -u origin master

echo "Your project has been pushed to GitHub successfully!"
echo "Visit: $REPO_URL to see your repository." 